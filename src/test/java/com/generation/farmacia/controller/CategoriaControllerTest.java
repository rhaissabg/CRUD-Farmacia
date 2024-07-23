package com.generation.farmacia.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.farmacia.model.Categoria;
import com.generation.farmacia.repository.CategoriaRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoriaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private CategoriaController categoriaController;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@BeforeAll
	void start() {
		categoriaRepository.deleteAll();
		categoriaController.post(new Categoria(0L, "Nome da Categoria", "Descrição da Categoria"));
	}

	@Test
	@DisplayName("Criar uma categoria")
	public void criarCategoria() {
		HttpEntity<Categoria> corpoRequisicao = new HttpEntity<Categoria>(
				new Categoria(0L, "Antidiabéticos", "Medicamento para diabetes"));
		ResponseEntity<Categoria> corpoResposta = testRestTemplate.exchange("/categorias", HttpMethod.POST,
				corpoRequisicao, Categoria.class);
		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
	}

	@Test
	@DisplayName("Atualizar uma categoria")
	public void atualizarCategoria() {
		ResponseEntity<Categoria> categoriaCadastrada = categoriaController
				.post(new Categoria(0L, "Anti-hipertensivos", "Medicamento para pressão"));
		Long idCadastrado = categoriaRepository.findById(categoriaCadastrada.getBody().getId()).get().getId();
		Categoria categoriaUpdate = new Categoria(idCadastrado, "Anti-hipertensivos", "Medicamento para pressão alta");
		HttpEntity<Categoria> corpoRequisicao = new HttpEntity<Categoria>(categoriaUpdate);
		ResponseEntity<Categoria> corpoResposta = testRestTemplate.exchange("/categorias", HttpMethod.PUT,
				corpoRequisicao, Categoria.class);
		assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
	}

	@Test
	@DisplayName("Mostrar todas as categorias")
	public void mostrarTodasCategorias() {
		categoriaController.post(
				new Categoria(0L, "Imunosupressores", "Medicamento para reduzir atividade do sistema imunológico"));
		categoriaController.post(new Categoria(0L, "Anticonvulsionantes", "Medicamento para previnir convulsões"));
		ResponseEntity<String> resposta = testRestTemplate.exchange("/categorias", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

	@Test
	@DisplayName("Deletar uma categoria")
	public void deletarCategoria() {
		Categoria categoria = new Categoria(1L, "Antifúngicos", "Medicamento para tratamento de infecções fúngicas");
		categoriaRepository.deleteById(categoria.getId());
	}

}
