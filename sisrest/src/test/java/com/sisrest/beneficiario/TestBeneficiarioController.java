/*
 * package com.sisrest.beneficiario;
 * 
 * import static org.junit.jupiter.api.Assertions.*; import static
 * org.mockito.ArgumentMatchers.anyInt; import static org.mockito.Mockito.when;
 * import static
 * org.springframework.test.web.client.match.MockRestRequestMatchers.content;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Set;
 * 
 * import javax.validation.ConstraintViolation; import
 * javax.validation.Validator;
 * 
 * import org.apache.el.util.Validation; import org.junit.Before; import
 * org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.BeforeEach;
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.junit.jupiter.params.ParameterizedTest; import
 * org.junit.jupiter.params.provider.ValueSource; import
 * org.junit.runner.RunWith; import org.mockito.ArgumentCaptor; import
 * org.mockito.Captor; import org.mockito.InjectMocks; import org.mockito.Mock;
 * import org.mockito.Mockito; import org.mockito.MockitoAnnotations; import
 * org.mockito.internal.util.reflection.Fields; import
 * org.mockito.junit.MockitoJUnitRunner; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.autoconfigure.AutoConfigureOrder; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.context.ActiveProfiles; import
 * org.springframework.test.util.ReflectionTestUtils; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.ResultMatcher; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper; import
 * com.sisrest.dto.beneficiario.BeneficiarioRequest; import
 * com.sisrest.dto.beneficiario.BeneficiarioResponse; import
 * com.sisrest.dto.contaBeneficiario.ContaBeneficiarioRequest; import
 * com.sisrest.exception.EmailEmUsoException; import
 * com.sisrest.model.entities.Beneficiario; import
 * com.sisrest.repositories.BeneficiarioRepository; import
 * com.sisrest.resources.BeneficiarioResource; import
 * com.sisrest.services.BeneficiarioService; import
 * com.sisrest.services.convertes.BeneficiarioServiceConvert; import
 * com.sisrest.services.convertes.ContaBeneficiarioServiceConvert;
 * 
 * @SpringBootTest
 * 
 * @ActiveProfiles("dsv")
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * class TestBeneficiarioController {
 * 
 * @InjectMocks
 * 
 * @Mock private static BeneficiarioResource controller;
 * 
 * @Mock private static BeneficiarioServiceConvert beneficiarioServiceConvert;
 * 
 * @InjectMocks
 * 
 * @Mock private static BeneficiarioService service;
 * 
 * @Mock private static BeneficiarioRepository repository; //dto
 * 
 * @Mock private static BeneficiarioRequest dto;
 * 
 * @Mock private static Beneficiario beneficiario;
 * 
 * @Mock private ResponseEntity resp;
 * 
 * private Set<ConstraintViolation<BeneficiarioRequest>> violations; private
 * static Validator validator;
 * 
 * @BeforeAll public static void setup() { service = new BeneficiarioService();
 * controller = new BeneficiarioResource(); beneficiarioServiceConvert = new
 * BeneficiarioServiceConvert(); ReflectionTestUtils.setField(service,
 * "beneficiarioRepository", repository);
 * ReflectionTestUtils.setField(controller, "beneficiarioService", service);
 * ReflectionTestUtils.setField(controller, "converterService",
 * beneficiarioServiceConvert);
 * 
 * 
 * }
 * 
 * @BeforeEach public void beforeEach() { MockitoAnnotations.openMocks(this);
 * 
 * dto = new BeneficiarioRequest(); dto.setAtivo(true); dto.getEdital();
 * dto.setId(1);
 * 
 * beneficiario = beneficiarioServiceConvert.dtoToBeneficiario(beneficiario);
 * 
 * }
 * 
 * @ParameterizedTest
 * 
 * public void saveInvaliIdAfeterJson(long id) throws Exception { if (id == 0) {
 * BeneficiarioRequest novo = new BeneficiarioRequest(); resp =
 * controller.save(novo); } else { dto.setId(id); resp = controller.create(dto);
 * } assertEquals("Não foi possível usar save, o campo nome está faltando!",
 * resp.getBody()); }
 * 
 * @Test void saveInvalidNull() throws Exception { // save invalid - obj is null
 * 
 * resp = controller.create(null);
 * 
 * assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
 * assertEquals("Não foi possível converter pois o objeto é nulo",
 * resp.getBody()); }
 * 
 * @Test public void updateInvalidDtoNull() throws Exception { // update invalid
 * - obj null
 * 
 * resp = controller.update(1, null); // controller
 * 
 * String error = " is null"; // final message of a NullPointException
 * System.out.println(resp.getBody().toString());
 * assertTrue(resp.getBody().toString().contains(error)); }
 * 
 * @Test public void updateInvalidIdNotFound() throws IllegalArgumentException,
 * Exception { // update invalid - Dto's Id not found in DB
 * when(repository.existsById((long) anyInt())).thenReturn(false);
 * 
 * resp = controller.update(0, beneficiario);
 * 
 * assertEquals("Não foi encontrado usuário com id 12", resp.getBody()); }
 * 
 * @Test public void deleteValid() { // delete valid - Htttp and body
 * when(repository.existsById((long) 1)).thenReturn(true);
 * 
 * resp = controller.delete(1);
 * 
 * assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
 * assertFalse(resp.hasBody()); }
 * 
 * @Test public void whenNonPublicField_thenReflectionTestUtilsSetField() {
 * Beneficiario employee = new Beneficiario();
 * ReflectionTestUtils.setField(employee, "id", 1);
 * 
 * assertTrue(employee.getId()== 1); }
 * 
 * 
 * @Test public void deleteInvalidIdNull() { // delete invalid - the id is 0
 * resp = controller.delete(0);
 * 
 * assertEquals("Não foi possível usar delete, o campo id está faltando!",
 * resp.getBody()); }
 * 
 * 
 * @Test public void findByIDInvalidNotFound() { // findByID invalid - not found
 * in DB when(repository.existsById((long) 9)).thenReturn(false); resp =
 * controller.getById(1);
 * 
 * assertEquals("Não foi encontrado beneficiario com id 9", resp.getBody()); }
 * 
 * @Test public void findByIDInvalidNull() { // findByID invalid - id is null
 * resp = controller.getById(0);
 * 
 * assertEquals("Não foi encontrado beneficiario com id 0", resp.getBody()); }
 * 
 * 
 * 
 * @Test public void getAllValidBeneficiarios() { // getAll valid - have no
 * beneficiario in DB List<Beneficiario> list = new ArrayList<>();
 * 
 * when(repository.findAll()).thenReturn(list); resp = controller.getAll();
 * 
 * assertEquals(HttpStatus.OK, resp.getStatusCode());
 * assertEquals(ArrayList.class, resp.getBody().getClass()); }
 * 
 * }
 */