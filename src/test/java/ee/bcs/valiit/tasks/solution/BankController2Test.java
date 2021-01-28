package ee.bcs.valiit.tasks.solution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BankController2Test {

@Autowired
private MockMvc mockMvc;

@Test
void createAccount() throws Exception {
    http://localhost:8080/bank2/createAccount?accountNr=EE123
    mockMvc.perform(MockMvcRequestBuilders.get( "/bank2/createAccount?accountNr=EE123")
            .contentType("application/json")
    ).andExpect(MockMvcResultMatchers.status().isOk());
}
@Test
    void customer () throws Exception {
    http://localhost:8080/bank2/customer?customerId=1&name=HeleVari&accountNr=EE423
    mockMvc.perform(MockMvcRequestBuilders.get( "/bank2/customer?customerId=1&name=HeleVari&accountNr=EE423")
            .contentType("application/json")
    ).andExpect(MockMvcResultMatchers.status().isOk());
}
@Test
void accountBalance () throws Exception {
    http://localhost:8080/bank2/accountBalance?accountNr=EE124
    mockMvc.perform(MockMvcRequestBuilders.get( "/bank2/accountBalance?accountNr=EE124")
            .contentType("application/json")
    ).andExpect(MockMvcResultMatchers.status().isOk());
}
@Test
void depositMoney () throws Exception {
    http://localhost:8080/bank2/depositMoney?accountNr=EE123&amount=12
    mockMvc.perform(MockMvcRequestBuilders.get( "/bank2/depositMoney?accountNr=EE123&amount=12")
            .contentType("application/json")
    ).andExpect(MockMvcResultMatchers.status().isOk());
}
@Test
void withdrawMoney () throws Exception {
    http://localhost:8080/bank2/withdrawMoney?accountNr=EE123&amount=12
    mockMvc.perform(MockMvcRequestBuilders.get( "/bank2/withdrawMoney?accountNr=EE123&amount=12")
            .contentType("application/json")
    ).andExpect(MockMvcResultMatchers.status().isOk());
}
@Test
void transferMoney () throws Exception {
    http://localhost:8080/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=5
    mockMvc.perform(MockMvcRequestBuilders.get("/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12")
            .contentType("application/json")
    ).andExpect(MockMvcResultMatchers.status().isOk());
}

}