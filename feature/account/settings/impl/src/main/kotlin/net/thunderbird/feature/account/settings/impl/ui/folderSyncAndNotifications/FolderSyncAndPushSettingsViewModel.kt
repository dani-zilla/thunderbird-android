package net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.thunderbird.feature.account.AccountId
import net.thunderbird.feature.account.settings.impl.domain.AccountSettingsDomainContract.UseCase
import net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications.FolderSyncAndPushSettingsContract.Effect
import net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications.FolderSyncAndPushSettingsContract.Event

internal class FolderSyncAndPushSettingsViewModel(
    private val getAccountDisplayFolders: UseCase.GetAccountDisplayFolders,
    private val accountId: AccountId,
) : FolderSyncAndPushSettingsContract.ViewModel() {

    init {
        getFolderList()
    }

    override fun event(event: Event) {
        when (event) {
            is Event.OnBackPressed -> {
                emitEffect(Effect.NavigateBack)
            }
            // TODO Event with dynamic ID. ID will be shaped by fetched folders and prefix from ID class
        }
    }

    private fun getFolderList() {
        viewModelScope.launch {
            getAccountDisplayFolders(accountId).collect { displayFolderList ->
                updateState { state -> state.copy(folderList = displayFolderList) }
            }
        }
    }
}
