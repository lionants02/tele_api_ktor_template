package th.nstda.thongkum.tele_api.config

interface Config {
    val openviduDefaultUrl: String
    val openviduDefaultSecret: String
    val hikariConfigFile: String
    val apiKey: String
}

/**
 * Application config
 */
val config: Config by lazy { ConfigWithSystemEnv() }