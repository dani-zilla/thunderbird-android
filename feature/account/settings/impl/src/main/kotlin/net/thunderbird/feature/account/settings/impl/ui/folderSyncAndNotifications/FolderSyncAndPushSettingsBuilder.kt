package net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications

import app.k9mail.legacy.ui.folder.DisplayFolder
import kotlinx.collections.immutable.toImmutableList
import net.thunderbird.core.common.resources.StringsResourceManager
import net.thunderbird.core.ui.setting.Setting
import net.thunderbird.core.ui.setting.SettingValue
import net.thunderbird.core.ui.setting.Settings

class FolderSyncAndPushSettingsBuilder : FolderSyncAndPushSettingsContract.SettingsBuilder {
    override fun build(
        state: FolderSyncAndPushSettingsContract.State,
        onEvent: (FolderSyncAndPushSettingsContract.Event) -> Unit,
    ): Settings {
        val settings = mutableListOf<Setting>()

        settings += addFolders(state.folderList)

        return settings.toImmutableList()
    }

    private fun addFolders(folders: List<DisplayFolder>): Settings {
        val settings = mutableListOf<Setting>()

        for (folder in folders) {
            val title = folder.folder.name.lowercase().replaceFirstChar { it.titlecase() }
            settings.add(
                SettingValue.SingleLineActionText(
                    id = folder.folder.id.toString(),
                    title = { title },
                    description = { null },
                    icon = { null },
                    value = title,
                    onClick = { },
                ),
            )
        }

        return settings.toImmutableList()
    }
}
