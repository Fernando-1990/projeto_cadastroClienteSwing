/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaaplication.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javaaplication.dao.Cliente;

/**
 *
 * @author Fernando
 */
public class ClienteSetDAO implements IClienteDAO{

    private final Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente: this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado != null) {
            this.set.remove(clienteEncontrado);
        }



    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado: this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setTel(cliente.getTel());
                    break;
                }
            }
        }

    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteCadastrado: this.set) {
            if (clienteCadastrado.getCpf().equals(cpf)) {
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}

