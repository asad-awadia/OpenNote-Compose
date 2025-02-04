package com.yangdai.opennote.presentation.component.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yangdai.opennote.R
import com.yangdai.opennote.presentation.util.Constants
import com.yangdai.opennote.presentation.viewmodel.SharedViewModel

@Composable
fun EditorPane(sharedViewModel: SharedViewModel) {

    val settingsState by sharedViewModel.settingsStateFlow.collectAsStateWithLifecycle()

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        ListItem(
            modifier = Modifier.clickable {

            },
            headlineContent = { Text(text = stringResource(R.string.default_view)) },
            supportingContent = {
                Text(
                    text = stringResource(R.string.default_view_for_note)
                )
            }
        )

        val viewOptions =
            listOf(stringResource(R.string.editing_view), stringResource(R.string.reading_view))

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = 0, count = viewOptions.size),
                onClick = {
                    sharedViewModel.putPreferenceValue(
                        Constants.Preferences.IS_DEFAULT_VIEW_FOR_READING,
                        false
                    )
                },
                selected = !settingsState.isDefaultViewForReading
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.EditNote, contentDescription = "EditNote"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(viewOptions[0])
                }
            }
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = 1, count = viewOptions.size),
                onClick = {
                    sharedViewModel.putPreferenceValue(
                        Constants.Preferences.IS_DEFAULT_VIEW_FOR_READING,
                        true
                    )
                },
                selected = settingsState.isDefaultViewForReading
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.MenuBook,
                        contentDescription = "ReadMode"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(viewOptions[1])
                }
            }
        }

        HorizontalDivider()

        ListItem(
            modifier = Modifier.clickable {

            },
            headlineContent = { Text(text = stringResource(R.string.default_editing_mode)) },
            supportingContent = {
                Text(
                    text = stringResource(R.string.default_editing_mode_for_note)
                )
            }
        )

        val modeOptions =
            listOf(stringResource(R.string.standard_mode), stringResource(R.string.lite_mode))

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = 0, count = modeOptions.size),
                onClick = {
                    sharedViewModel.putPreferenceValue(
                        Constants.Preferences.IS_DEFAULT_LITE_MODE,
                        false
                    )
                },
                selected = !settingsState.isDefaultLiteMode
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.standard),
                        contentDescription = "StandardMode"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(modeOptions[0])
                }
            }
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = 1, count = modeOptions.size),
                onClick = {
                    sharedViewModel.putPreferenceValue(
                        Constants.Preferences.IS_DEFAULT_LITE_MODE,
                        true
                    )
                },
                selected = settingsState.isDefaultLiteMode
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.lite),
                        contentDescription = "LiteMode"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(modeOptions[1])
                }
            }
        }
    }
}
