package net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.thunderbird.core.ui.contract.mvi.observe
import net.thunderbird.core.ui.setting.SettingViewProvider
import net.thunderbird.feature.account.AccountId
import net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications.FolderSyncAndPushSettingsContract.Effect
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
internal fun FolderSyncAndPushSettingsScreen(
    accountId: AccountId,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FolderSyncAndPushSettingsContract.ViewModel = koinViewModel<FolderSyncAndPushSettingsViewModel> {
        parametersOf(accountId)
    },
    provider: SettingViewProvider = koinInject(),
    builder: FolderSyncAndPushSettingsContract.SettingsBuilder = koinInject(),
) {
    val (state, dispatch) = viewModel.observe { effect ->
        when (effect) {
            is Effect.NavigateBack -> {
                onBack()
            }
        }
    }
    BackHandler(onBack = onBack)

    FolderSyncAndPushContent(
        state = state.value,
        onEvent = { dispatch(it) },
        provider = provider,
        builder = builder,
        modifier = modifier,
    )

}
