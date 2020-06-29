import com.apress.prospring5.ch2.decoupled.MessageRenderer
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

fun main() {
    // 在类路径获取XML配置文件，创建ApplicationContext实例
    val ctx: ApplicationContext = ClassPathXmlApplicationContext("spring/app-context.xml")
    // 类型安全地（指定了类型）获取 MessageRenderer Bean
    val mr = ctx.getBean("renderer", MessageRenderer::class.java)
    mr.render()
}
