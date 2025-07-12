package quest.toybox.sculptor.extension

enum class ContributorRank {
    PROJECT_OWNER,
    MAINTAINER,
    PROGRAMMER,
    ARTIST,
    TRANSLATOR;

    fun isAuthor() = this == PROJECT_OWNER || this == MAINTAINER

    fun showInCredits() = !isAuthor()
}