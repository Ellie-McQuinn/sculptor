package quest.toybox.sculptor.minecraft

@Suppress("unused")
enum class MCVersions(
    val version: String,
    val normalizedVersion: String,
    val minimumFabricLoaderVersion: String,
    val neoFormVersion: String
) {
    MC_1_20_2(
        version = "1.20.2",
        normalizedVersion = "1.20.2",
        minimumFabricLoaderVersion = "0.14.22",
        neoFormVersion = "1.20.2-20241215.201144"
    ),
    // region MC_1_20_3, ...
    MC_23W40A(
        version = "23w40a",
        normalizedVersion = "1.20.3-alpha.23.40.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w40a-20231004.201141"
    ),
    MC_23W41A(
        version = "23w41a",
        normalizedVersion = "1.20.3-alpha.23.41.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w41a-20231012.060129"
    ),
    MC_23W42A(
        version = "23w42a",
        normalizedVersion = "1.20.3-alpha.23.42.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w42a-20231019.115212"
    ),
    MC_23W43A(
        version = "23w43a",
        normalizedVersion = "1.20.3-alpha.23.43.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w43a-20231025.230911"
    ),
    MC_23W43B(
        version = "23w43b",
        normalizedVersion = "1.20.3-alpha.23.43.b",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w43b-20231030.123645"
    ),
    MC_23W44A(
        version = "23w44a",
        normalizedVersion = "1.20.3-alpha.23.44.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w44a-20231106.084427"
    ),
    MC_23W45A(
        version = "23w45a",
        normalizedVersion = "1.20.3-alpha.23.45.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w45a-20231108.200637"
    ),
    MC_23W46A(
        version = "23w46a",
        normalizedVersion = "1.20.3-alpha.23.46.a",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "23w46a-20231116.200556"
    ),
    MC_1_20_3_PRE_1(
        version = "1.20.3-pre1",
        normalizedVersion = "1.20.3-beta.1",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.3-pre1-20231120.191647"
    ),
    MC_1_20_3_PRE_2(
        version = "1.20.3-pre2",
        normalizedVersion = "1.20.3-beta.2",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.3-pre2-20231122.210419"
    ),
    MC_1_20_3_PRE_3(
        version = "1.20.3-pre3",
        normalizedVersion = "1.20.3-beta.3",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.3-pre3-20231127.162425"
    ),
    MC_1_20_3_PRE_4(
        version = "1.20.3-pre4",
        normalizedVersion = "1.20.3-beta.4",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.3-pre4-20231128.162426"
    ),
    MC_1_20_3_RC_1(
        version = "1.20.3-rc1",
        normalizedVersion = "1.20.3-rc.1",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.3-rc1-20231130.162433"
    ),
    MC_1_20_3(
        version = "1.20.3",
        normalizedVersion = "1.20.3",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.3-20241215.201103"
    ),
    // endregion
    // region MC_1_20_4, ...
    MC_1_20_4_RC_1(
        version = "1.20.4-rc1",
        normalizedVersion = "1.20.4-rc.1",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.4-rc1-20231206.173914"
    ),
    MC_1_20_4(
        version = "1.20.4",
        normalizedVersion = "1.20.4",
        minimumFabricLoaderVersion = "0.14.23",
        neoFormVersion = "1.20.4-20240627.114801"
    ),
    // endregion
    // region MC_1_20_5, ...
    MC_23W51A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.3",
        neoFormVersion = ""
    ),
    MC_23W51B(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.3",
        neoFormVersion = ""
    ),
    MC_24W03A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W03B(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W04A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W05A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W05B(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W06A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W07A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W09A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W10A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W11A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W12A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_24W13A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    POISONOUS_POTATO(
        version = "24w14potato",
        normalizedVersion = "1.20.5-alpha.24.12.potato",
        minimumFabricLoaderVersion = "0.15.9",
        neoFormVersion = "24w14potato-20240402.092655"
    ),
    MC_24W14A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_PRE_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_PRE_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_PRE_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_PRE_4(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_RC_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5_RC_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_5(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    // endregion
    // region MC_1_20_6, ...
    MC_1_20_6_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    MC_1_20_6(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.6",
        neoFormVersion = ""
    ),
    // endregion
    // region MC_1_21, ...
    MC_24W18A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_24W19A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_24W19B(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_24W20A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_24W21A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_24W21B(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21_PRE_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21_PRE_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21_PRE_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21_PRE_4(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    // endregion
    // region MC_1_21_1, ...
    MC_1_21_1_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = ""
    ),
    MC_1_21_1(
        version = "1.21.1",
        normalizedVersion = "1.21.1",
        minimumFabricLoaderVersion = "0.15.11",
        neoFormVersion = "1.21.1-20240808.144430"
    ),
    // endregion
    // region MC_1_21_2, ...
    MC_24W33A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W34A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W35A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W36A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W37A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W38A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W39A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_24W40A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_PRE_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_PRE_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_PRE_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_PRE_4(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_PRE_5(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2_RC_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    MC_1_21_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    // endregion
    MC_1_21_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.3",
        neoFormVersion = ""
    ),
    // region MC_1_21_4, ...
    MC_24W44A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_24W45A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_24W46A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4_PRE_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4_PRE_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4_PRE_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4_RC_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4_RC_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    MC_1_21_4(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.9",
        neoFormVersion = ""
    ),
    // endregion
    // region MC_1_21_5, ...
    MC_25W02A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W03A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W04A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W05A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W06A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W07A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W08A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W09A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W09B(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_25W10A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_1_21_5_PRE_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_1_21_5_PRE_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_1_21_5_PRE_3(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_1_21_5_RC_1(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_1_21_5_RC_2(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = ""
    ),
    MC_1_21_5(
        version = "1.21.5",
        normalizedVersion = "1.21.5",
        minimumFabricLoaderVersion = "0.16.10",
        neoFormVersion = "1.21.5-20250325.162830"
    ),
    // endregion
    CRAFT_MINE(
        version = "25w14craftmine",
        normalizedVersion = "1.21.6-alpha.25.14.craftmine",
        minimumFabricLoaderVersion = "0.16.12",
        neoFormVersion = "25w14craftmine-20250401.222524"
    ),
    // region MC_1_21_6
    MC_25W15A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_25W16A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_25W17A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_25W18A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_25W19A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_25W20A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_25W21A(
        version = "",
        normalizedVersion = "",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = ""
    ),
    MC_1_21_6_PRE_1(
        version = "1.21.6-pre1",
        normalizedVersion = "1.21.6-beta.1",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.6-pre1-20250528.104215"
    ),
    MC_1_21_6_PRE_2(
        version = "1.21.6-pre2",
        normalizedVersion = "1.21.6-beta.2",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.6-pre2-20250602.144525"
    ),
    MC_1_21_6_PRE_3(
        version = "1.21.6-pre3",
        normalizedVersion = "1.21.6-beta.3",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.6-pre3-20250604.141722"
    ),
    MC_1_21_6_PRE_4(
        version = "1.21.6-pre4",
        normalizedVersion = "1.21.6-beta.4",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.6-pre4-20250611.141253"
    ),
    MC_1_21_6_RC_1(
        version = "1.21.6-rc1",
        normalizedVersion = "1.21.6-rc.1",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.6-rc1-20250616.124039"
    ),
    MC_1_21_6(
        version = "1.21.6",
        normalizedVersion = "1.21.6",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.6-20250617.151856"
    ),
    // endregion
    // region MC_1_21_7
    MC_1_21_7_RC_1(
        version = "1.21.7-rc1",
        normalizedVersion = "1.21.7-rc.1",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.7-rc1-20250625.154307"
    ),
    MC_1_21_7_RC_2(
        version = "1.21.7-rc2",
        normalizedVersion = "1.21.7-rc.2",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.7-rc2-20250626.145635"
    ),
    MC_1_21_7(
        version = "1.21.7",
        normalizedVersion = "1.27.1",
        minimumFabricLoaderVersion = "0.16.13",
        neoFormVersion = "1.21.7-20250630.141722"
    );
    // endregion

    fun isRelease(): Boolean {
        return Regex("\\d+\\.\\d+(\\.\\d+)?").matches(version)
    }

    fun isBranched(): Boolean {
        return this == POISONOUS_POTATO || this == CRAFT_MINE
    }

    fun hasSplitDatagens(): Boolean {
        return this >= MC_24W45A
    }

    fun getCurseForgeName(): String {
        return if (isRelease()) {
             version
        } else if (this == POISONOUS_POTATO) {
            "1.20.5-Snapshot"
        } else if (this == CRAFT_MINE) {
            "1.21.5-Snapshot"
        } else if (this < MC_1_20_3) {
            "1.20.3-Snapshot"
        } else if (this < MC_1_20_4) {
            "1.20.4"
        } else if (this < MC_1_20_5) {
            "1.20.5-Snapshot"
        } else if (this < MC_1_20_6) {
            "1.20.6"
        } else if (this < MC_1_21) {
            "1.21-Snapshot"
        } else if (this < MC_1_21_1) {
            "1.21_1-Snapshot"
        } else if (this < MC_1_21_2) {
            "1.21_2-Snapshot"
        } else if (this < MC_1_21_3) {
            "1.21_3"
        } else if (this < MC_1_21_4) {
            "1.21_4-Snapshot"
        } else if (this < MC_1_21_5) {
            "1.21_5-Snapshot"
        } else if (this < MC_1_21_6) {
            "1.21_6-Snapshot"
        } else if (this < MC_1_21_7) {
            "1.21_7"
        } else {
            throw IllegalStateException("Unknown version.")
        }
    }

    // We don't currently need to alter anything.
    // https://github.com/modrinth/code/blob/main/apps/labrinth/src/background_task.rs#L187
    fun getModrinthName(): String {
        return version
    }
}