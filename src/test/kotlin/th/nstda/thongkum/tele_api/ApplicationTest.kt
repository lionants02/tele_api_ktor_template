package th.nstda.thongkum.tele_api

import io.ktor.http.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import th.nstda.thongkum.tele_api.plugins.configureRouting
import th.nstda.thongkum.tele_api.plugins.configureSerialization

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testSerialization() = testApplication {
        application {
            configureSerialization()
        }
        client.get("/json/kotlinx-serialization").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("{\"hello\":\"world\"}", bodyAsText())
        }
    }
}