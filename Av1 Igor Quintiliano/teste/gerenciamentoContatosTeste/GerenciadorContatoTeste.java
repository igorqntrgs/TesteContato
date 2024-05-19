package gerenciamentoContatosTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gerenciamentoContatos.Contato;
import gerenciamentoContatos.GerenciadorContato;

public class GerenciadorContatoTeste {
	private GerenciadorContato gerenciador;

    @Before
    public void setUp() {
        gerenciador = new GerenciadorContato();
    }

    @After
    public void tearDown() {
        gerenciador = null;
    }

    @Test
    public void testAdicionarContato() {
        // Montagem de cenário
        Contato contato1 = new Contato(1, "Igor Quintiliano", "135792468");
        Contato contato2 = new Contato(2, "Julia Abreu", "246813579");

        // Execução
        gerenciador.adicionarContato(contato1);
        gerenciador.adicionarContato(contato2);

        // Verificação e análise
        Contato result1 = gerenciador.pesquisarContatoPorId(1);
        Contato result2 = gerenciador.pesquisarContatoPorId(2);
        assertNotNull(result1);
        assertEquals("Igor Quintiliano", result1.getNome());
        assertNotNull(result2);
        assertEquals("Julia Abreu", result2.getNome());
    }

    @Test
    public void testRemoverContato() {
        // Montagem de cenário
        Contato contato1 = new Contato(1, "Igor Quintiliano", "135792468");
        gerenciador.adicionarContato(contato1);

        // Execução
        gerenciador.removerContato(1);

        // Verificação e análise
        Contato result = gerenciador.pesquisarContatoPorId(1);
        assertNull(result);
    }

    @Test
    public void testPesquisarContatoPorId() {
        // Montagem de cenário
        Contato contato1 = new Contato(1, "Igor Quintiliano", "135792468");
        Contato contato2 = new Contato(2, "Julia Abreu", "246813579");
        gerenciador.adicionarContato(contato1);
        gerenciador.adicionarContato(contato2);

        // Execução
        Contato result1 = gerenciador.pesquisarContatoPorId(1);
        Contato result2 = gerenciador.pesquisarContatoPorId(2);
        Contato result3 = gerenciador.pesquisarContatoPorId(3);

        // Verificação e análise
        assertNotNull(result1);
        assertEquals("Igor Quintiliano", result1.getNome());
        assertNotNull(result2);
        assertEquals("Julia Abreu", result2.getNome());
        assertNull(result3);
    }
}
