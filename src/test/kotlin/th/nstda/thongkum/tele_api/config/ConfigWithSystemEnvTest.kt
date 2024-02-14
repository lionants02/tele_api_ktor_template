package th.nstda.thongkum.tele_api.config

import org.junit.Test
import kotlin.test.assertEquals

class ConfigWithSystemEnvTest {

    @Test
    fun randomStringByKotlinRandom() {
        val config = ConfigWithSystemEnv()
        val test = config.randomStringByKotlinRandom(20)
        println(test)
        assertEquals(20, test.length)
    }
}