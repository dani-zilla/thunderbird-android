package net.thunderbird.feature.account.settings.impl.domain.usecase

import app.k9mail.legacy.ui.folder.DisplayFolder
import app.k9mail.legacy.ui.folder.DisplayFolderRepository
import assertk.assertThat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import net.thunderbird.account.fake.FakeAccountData
import net.thunderbird.feature.account.AccountId
import net.thunderbird.feature.account.settings.impl.domain.AccountSettingsDomainContract
import net.thunderbird.feature.mail.folder.FolderType
import net.thunderbird.feature.mail.folder.api.Folder
import org.junit.Test

class GetAccountFoldersTest {

    @Test
    fun `should emit folders when present`() = runTest {
        val testSubject = createTestUseCase()
        val folderFlow = testSubject(FakeAccountData.ACCOUNT_ID)
        assertThat(folderFlow.first().isNotEmpty())
    }

    private fun createTestUseCase(): AccountSettingsDomainContract.UseCase.GetAccountFolders {
        return GetAccountFolders(
            folderRepository = FakeDisplayFolderRepository(accountFoldersFlow())
        )
    }

    private fun accountFoldersFlow(): Flow<List<DisplayFolder>> = flowOf(
        listOf(
            DisplayFolder(
                folder = Folder(
                    id = 0,
                    name = "Inbox",
                    type = FolderType.INBOX,
                    isLocalOnly = false,
                ),
                isInTopGroup = true,
                unreadMessageCount = 0,
                starredMessageCount = 0,
                pathDelimiter = "",
            )
        )
    )
    private class FakeDisplayFolderRepository(
        private val foldersFlow: Flow<List<DisplayFolder>>,
    ) : DisplayFolderRepository {
        override fun getDisplayFoldersFlow(
            accountId: AccountId,
            includeHiddenFolders: Boolean,
        ): Flow<List<DisplayFolder>> {
            return foldersFlow
        }

        override fun getDisplayFoldersFlow(accountId: AccountId): Flow<List<DisplayFolder>> {
            return foldersFlow
        }
    }
}
