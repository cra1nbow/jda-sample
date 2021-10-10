import dev.minn.jda.ktx.await
import dev.minn.jda.ktx.light
import dev.minn.jda.ktx.listener
import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.apache.log4j.LogManager
import kotlin.time.measureTime

class PracticeBot: ListenerAdapter() {
    companion object {
        val LOGGER = LogManager.getLogger(PracticeBot::class.java)

        @JvmStatic
        fun main(args: Array<String>) {
            val dotenv = dotenv()
            val jda = light(dotenv["TOKEN"])
            jda.listener<MessageReceivedEvent> {
                if (it.message.contentRaw.startsWith("!ping")) {
                    var message: Message
                    val time = measureTime {
                        message = it.message.reply("Pong!").await()
                    }.inWholeMilliseconds
                    message.editMessage("Pong!: $time ms").queue()
                    cancel()
                }
            }
        }
    }
}

