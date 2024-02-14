package th.nstda.thongkum.tele_api.config

import th.nstda.thongkum.tele_api.getLogger
import kotlin.random.Random

class ConfigWithSystemEnv : Config {
    private fun getSystemValue(envName: String): String? {
        val result = System.getenv(envName)
        log.debug("$envName is $result")
        return result
    }

    /**
     * Random string
     * fun from https://www.baeldung.com/kotlin/random-alphanumeric-string
     */
    fun randomStringByKotlinRandom(length: Int): String {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..length)
            .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
            .joinToString("")
    }

    override val openviduDefaultUrl: String
        get() = TODO("Not yet implemented")
    override val openviduDefaultSecret: String
        get() = TODO("Not yet implemented")
    override val hikariConfigFile: String
        get() = getSystemValue("HIKARI_CONFIG_FILE") ?: "".ifEmpty { "resources/hikarisimple.properties" }
    override val apiKey: String
        get() = getSystemValue("API_KEY") ?: "".ifEmpty {
            val key = randomStringByKotlinRandom(50)
            log.info("Rnadom api key is $key")
            key
        }

    companion object {
        private val log by lazy { getLogger(ConfigWithSystemEnv::class.java) }
    }
}