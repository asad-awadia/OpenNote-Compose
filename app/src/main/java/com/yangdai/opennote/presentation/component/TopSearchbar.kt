package com.yangdai.opennote.presentation.component

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.automirrored.outlined.Sort
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yangdai.opennote.R
import com.yangdai.opennote.presentation.event.ListEvent
import com.yangdai.opennote.presentation.viewmodel.MainScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TopSearchbar(
    scope: CoroutineScope,
    showMenuIcon: Boolean = true,
    drawerState: DrawerState,
    viewModel: MainScreenViewModel,
    onActiveChange: (Boolean) -> Unit
) {

    val historySet by viewModel.historyStateFlow.collectAsStateWithLifecycle()

    var inputText by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(active) {
        onActiveChange(active)
    }

    val configuration = LocalConfiguration.current
    val orientation = remember(configuration) { configuration.orientation }

    fun search(text: String) {
        if (text.isNotEmpty()) {
            val newSet = historySet.toMutableSet()
            newSet.add(text)
            viewModel.putHistoryStringSet(newSet)
        }
        active = false
        viewModel.onListEvent(ListEvent.Search(text))
    }

    @Composable
    fun LeadingIcon() {
        if (showMenuIcon) {
            AnimatedContent(targetState = active, label = "leading") {
                if (it) {
                    IconButton(onClick = { search(inputText) }) {
                        Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
                    }
                } else {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.MenuOpen,
                            contentDescription = "Open Menu"
                        )
                    }
                }
            }
        } else {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
        }
    }

    @Composable
    fun TrailingIcon() {
        AnimatedContent(targetState = active, label = "trailing") {
            if (it) {
                IconButton(onClick = {
                    if (inputText.isNotEmpty()) {
                        inputText = ""
                    } else {
                        search("")
                    }
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = "Clear"
                    )
                }
            } else {
                IconButton(onClick = { viewModel.onListEvent(ListEvent.ToggleOrderSection) }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.Sort,
                        contentDescription = "Sort"
                    )
                }
            }
        }
    }

    @Composable
    fun History() {

        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.History,
                    contentDescription = "History"
                )
            },
            headlineContent = { Text(text = stringResource(R.string.search_history)) },
            trailingContent = {
                IconButton(onClick = { viewModel.putHistoryStringSet(emptySet()) }) {
                    Icon(
                        imageVector = Icons.Outlined.DeleteForever,
                        contentDescription = "Clear History"
                    )
                }
            }
        )

        FlowRow(
            Modifier.padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            historySet.forEach {
                SuggestionChip(
                    modifier = Modifier.defaultMinSize(48.dp),
                    onClick = { inputText = it },
                    label = {
                        Text(
                            text = it,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    })
            }
        }
    }

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(
                query = inputText,
                onQueryChange = { inputText = it },
                onSearch = { search(it) },
                active = active,
                onActiveChange = { active = it },
                placeholder = { Text(text = stringResource(R.string.search)) },
                leadingIcon = { LeadingIcon() },
                trailingIcon = { TrailingIcon() }
            ) {
                History()
            }
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DockedSearchBar(
                query = inputText,
                onQueryChange = { inputText = it },
                onSearch = { search(it) },
                active = active,
                onActiveChange = { active = it },
                placeholder = { Text(text = "Search") },
                leadingIcon = { LeadingIcon() },
                trailingIcon = { TrailingIcon() }
            ) {
                History()
            }
        }
    }
}
