package com.lavendimia.main.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lavendimia.main.collections.MCliente;
import com.lavendimia.main.entity.Cliente;

@Component("mapper")
public class Mapper {
	/* Se crea el metodo que mapeara el listado de clientes a listado de clientes mapeados */
	public static List<MCliente> convertiListaclientes(List<Cliente> listClientes){
		List<MCliente> mClientes = new ArrayList<>();
		/* Se recorre la lista de clientes */
		for(Cliente cliente : listClientes) {
			/* Se asigna cada objeto de la lista de profesores al listado de clientes mapeados */
			mClientes.add(new MCliente(cliente));
		}
		/* Se regresa el listado */
		return mClientes;
	}
}
