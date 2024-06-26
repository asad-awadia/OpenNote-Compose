package com.yangdai.opennote.presentation.state

import androidx.compose.runtime.Stable
import com.yangdai.opennote.data.local.entity.FolderEntity

@Stable
data class NoteState(
    val id: Long? = null,
    val title: String = "",
    val content: String = "",
    val folderId: Long? = null,
    val isMarkdown: Boolean = true,
    val timestamp: Long? = null,
    val folders: List<FolderEntity> = emptyList()
)