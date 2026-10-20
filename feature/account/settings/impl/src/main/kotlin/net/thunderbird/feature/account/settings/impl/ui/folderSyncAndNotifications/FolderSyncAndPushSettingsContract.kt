package net.thunderbird.feature.account.settings.impl.ui.folderSyncAndNotifications

import androidx.compose.runtime.Stable
import net.thunderbird.core.ui.contract.mvi.BaseViewModel
import net.thunderbird.core.ui.setting.Settings

interface  FolderSyncAndPushSettingsContract {

    abstract class ViewModel : BaseViewModel<State, Event, Effect>(
        initialState = State()
    )

    @Stable
    data class State(
        val placeholder: Boolean = true
    )

    sealed interface Event {
        data object OnBackPressed : Event
    }

    sealed interface Effect {
        object NavigateBack : Effect
    }

    fun interface SettingsBuilder {
        fun build(
            state: State,
            onEvent: (Event) -> Unit,
        ): Settings
    }
}
