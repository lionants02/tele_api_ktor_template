package th.nstda.thongkum.tele_api

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import th.nstda.thongkum.tele_api.plugins.configureHTTP
import th.nstda.thongkum.tele_api.plugins.configureRouting
import th.nstda.thongkum.tele_api.plugins.configureSerialization
import th.nstda.thongkum.tele_api.services.conference.configureVdoRouting

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureRouting()
    configureVdoRouting()
}
