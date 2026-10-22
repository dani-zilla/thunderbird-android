package net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import net.thunderbird.core.ui.setting.Setting
import net.thunderbird.core.ui.setting.SettingViewProvider
import net.thunderbird.feature.account.settings.R
import net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications.FolderSyncAndPushSettingsContract.Event
import net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications.FolderSyncAndPushSettingsContract.State
import net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications.FolderSyncAndPushSettingsContract.SettingsBuilder

@Composable
internal fun FolderSyncAndPushContent(
    state: State,
    onEvent: (Event) -> Unit,
    provider: SettingViewProvider,
    builder: SettingsBuilder,
    modifier: Modifier = Modifier,
) {
    val settings = remember(state, builder, onEvent) {
        builder.build(state = state, onEvent = onEvent)
    }

    provider.SettingView(
        title = stringResource(R.string.account_settings_folder_sync_and_push),
        settings = settings,
        onSettingValueChange = { setting -> handleSettingChange(setting, onEvent) },
        onBack = { onEvent(Event.OnBackPressed) },
        modifier = modifier,
        actions = {
            // TODO
        }
    )
}

private fun handleSettingChange(
    setting: Setting,
    onEvent: (Event) -> Unit,
) {
    // TODO
}
