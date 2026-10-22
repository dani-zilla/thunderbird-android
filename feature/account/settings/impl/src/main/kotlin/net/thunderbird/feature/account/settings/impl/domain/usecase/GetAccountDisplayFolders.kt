package net.thunderbird.feature.account.settings.impl.domain.usecase

import app.k9mail.legacy.ui.folder.DisplayFolder
import app.k9mail.legacy.ui.folder.DisplayFolderRepository
import kotlinx.coroutines.flow.Flow
import net.thunderbird.feature.account.AccountId
import net.thunderbird.feature.account.settings.impl.domain.AccountSettingsDomainContract.UseCase

internal class GetAccountDisplayFolders (
    private val folderRepository: DisplayFolderRepository,
) : UseCase.GetAccountDisplayFolders {
    override fun invoke(accountId: AccountId): Flow<List<DisplayFolder>> {
        return folderRepository.getDisplayFoldersFlow(accountId = accountId, includeHiddenFolders = true)
    }
}
