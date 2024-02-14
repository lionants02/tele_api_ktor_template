package th.nstda.thongkum.tele_api.config

import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option

class ConfigWithParameter(args: Array<String>) : Config {

    @Option(name = "-vidu", usage = "vidu http api")
    private var _openviduDefaultUrl = ""

    @Option(name = "-vidu_defult_secret", usage = "vidu secret api")
    private var _openviduDefaultSecret = ""

    override val openviduDefaultUrl: String
        get() = if (_openviduDefaultUrl.isNullOrBlank())
            System.getenv("VIDU_DEFAULT_URL")
        else
            _openviduDefaultUrl
    override val openviduDefaultSecret: String
        get() = if (_openviduDefaultSecret.isNullOrBlank())
            System.getenv("VIDU_SECRET_URL")
        else
            _openviduDefaultSecret

    override val hikariConfigFile: String
        get() = TODO("Not yet implemented")
    override val apiKey: String
        get() = TODO("Not yet implemented")

    init {
        try {
            println(args.toList())
            CmdLineParser(this).parseArgument(*args)
        } catch (ex: CmdLineException) {
            throw ex
        }
    }
}