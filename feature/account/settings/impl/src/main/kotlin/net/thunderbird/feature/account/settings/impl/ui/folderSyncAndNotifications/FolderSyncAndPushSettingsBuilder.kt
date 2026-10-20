package net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications

import kotlinx.collections.immutable.toImmutableList
import net.thunderbird.core.common.resources.StringsResourceManager
import net.thunderbird.core.ui.setting.Setting
import net.thunderbird.core.ui.setting.Settings

class FolderSyncAndPushSettingsBuilder(
    private val resources: StringsResourceManager,
) : FolderSyncAndPushSettingsContract.SettingsBuilder {
    override fun build(
        state: FolderSyncAndPushSettingsContract.State,
        onEvent: (FolderSyncAndPushSettingsContract.Event) -> Unit,
    ): Settings {
        val settings = mutableListOf<Setting>()

        // TODO

        return settings.toImmutableList()
    }
}
