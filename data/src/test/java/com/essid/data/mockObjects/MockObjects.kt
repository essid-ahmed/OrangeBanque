package com.essid.data.mockObjects

import com.essid.data.dto.LicenseDto
import com.essid.data.dto.OwnerDto
import com.essid.data.dto.PermissionsDto
import com.essid.data.dto.RepoDto
import com.essid.domain.entities.Repo

class MockObjects {

    companion object {
        fun fakeRepoDtoObject():
                RepoDto {
            return RepoDto(
                id = 1,
                nodeId = "",
                name = "",
                fullName = "full_name",
                private = false,
                ownerDto = fakeOwnerDto(),
                htmlUrl = "html_url",
                description = "description",
                fork = false,
                url = "url",
                forksUrl = "forks_url",
                keysUrl = "keys_url",
                collaboratorsUrl = "collaborators_url",
                teamsUrl = "teams_url",
                hooksUrl = "hooks_url",
                issueEventsUrl = "issue_events_url",
                eventsUrl = "events_url",
                assigneesUrl = "assignees_url",
                branchesUrl = "tags_url",
                tagsUrl = "blobs_url",
                blobsUrl = "git_tags_url",
                gitTagsUrl = "git_refs_url",
                gitRefsUrl = "trees_url",
                treesUrl = "statuses_url",
                statusesUrl = "languages_url",
                languagesUrl = "stargazers_url",
                stargazersUrl = "contributors_url",
                contributorsUrl = "subscribers_url",
                subscribersUrl = "subscription_url",
                subscriptionUrl = "commits_url",
                commitsUrl = "git_commits_url",
                gitCommitsUrl = "comments_url",
                commentsUrl = "issue_comment_url",
                issueCommentUrl = "contents_url",
                contentsUrl = "compare_url",
                compareUrl = "merges_url",
                mergesUrl = "archive_url",
                archiveUrl = "downloads_url",
                downloadsUrl = "issues_url",
                issuesUrl = "pulls_url",
                pullsUrl = "milestones_url",
                milestonesUrl = "notifications_url",
                notificationsUrl = "labels_url",
                labelsUrl = "releases_url",
                releasesUrl = "deployments_url",
                deploymentsUrl = "created_at",
                createdAt = "updated_at",
                updatedAt = "pushed_at",
                pushedAt = "git_url",
                gitUrl = "ssh_url",
                sshUrl = "clone_url",
                cloneUrl = "svn_url",
                svnUrl = "svn_url",
                homepage = "homepage",
                size = 2,
                stargazersCount = 3,
                watchersCount = 6,
                language = "",
                hasIssues = false,
                hasProjects = false,
                hasDownloads = false,
                hasWiki = false,
                hasPages = true,
                forksCount = 7,
                mirrorUrl = "mirror_url",
                archived = false,
                disabled = true,
                openIssuesCount = 6,
                license = fakeLicenseDto(),
                allowForking = true,
                isTemplate = true,
                webCommitSignOffRequired = false,
                topics = emptyList<String>(),
                visibility = "visibility",
                forks = 9,
                openIssues = 5,
                watchers = 2,
                defaultBranch = "default_branch",
                permissionsDto = fakePermissionsDto()
            )
        }

        private fun fakeLicenseDto(): LicenseDto? {
            return LicenseDto(
                key = "key",
                name = "name",
                spdxId = "sp",
                url = "url",
                nodeId = "node"
            )
        }

        private fun fakePermissionsDto(): PermissionsDto {
            return PermissionsDto(
                admin = true,
                maintain = false,
                push = true,
                triage = false,
                pull = true
            )
        }

        private fun fakeOwnerDto(): OwnerDto {
            return OwnerDto(
                login = "login",
                id = 1,
                nodeId = "node_id",
                avatarUrl = "url",
                gravatarId = "gravatar",
                url = "url",
                htmlUrl = "html_url",
                followersUrl = "followers_url",
                followingUrl = "following_url",
                gistsUrl = "gists_url",
                starredUrl = "starred_url",
                subscriptionsUrl = "subscriptions_url",
                organizationsUrl = "organizations_url",
                reposUrl = "repos_url",
                eventsUrl = "events_url",
                receivedEventsUrl = "received_events_url",
                type = "type",
                siteAdmin = false
            )

        }

        fun fakeRepoObject():
                Repo {
            return Repo(
                id = 1,
                fullName = "JetBrains/JPS",
                forks = 2,
                openIssues = 2,
                watchers = 5,
                description = "Gant based build framework + dsl, with declarative project structure definition and automatic IntelliJ IDEA projects build"
            )
        }

        fun fakeReposDtoList(): List<RepoDto> {
            return listOf(fakeRepoDtoObject())
        }
    }
}