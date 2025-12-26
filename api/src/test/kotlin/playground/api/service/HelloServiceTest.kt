package playground.api.service

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest(classes = [HelloService::class])
class HelloServiceTest {

    @Autowired
    private lateinit var helloService: HelloService

    @Test
    fun shouldReturnHelloWorldString(){
        val greetUser = helloService.greetUser()
        assertEquals("Hello World", greetUser)
    }
}