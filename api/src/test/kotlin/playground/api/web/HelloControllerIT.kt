package playground.api.web

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIT @Autowired constructor(private val mockMvc: MockMvc, private val objectMapper: ObjectMapper) {

    private val url = "http://localhost:8080/api/v1/hello"

    @Test
    fun shouldReturn200(){
        mockMvc.get(url){
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentTypeCompatibleWith("application/json") }
        }
    }

}