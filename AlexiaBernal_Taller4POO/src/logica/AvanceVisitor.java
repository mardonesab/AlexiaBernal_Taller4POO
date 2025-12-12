package logica;

import dominio.NotaAsignatura;

public interface AvanceVisitor 
{
	void visit(NotaAsignatura nota);
}
