package springmvc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.entity.Empleado;
import springmvc.entity.Nomina;

import java.util.List;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Empleado recogerEmpleado(int id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Empleado.class, id);
    }

    @Override
    public Nomina recogerSueldo(String dni) {

        Session session = sessionFactory.getCurrentSession();

        Query<Nomina> query =  session.createQuery("from Nomina WHERE dni=" + dni, Nomina.class);
        
        Nomina nomina = query.getSingleResult();

        return nomina;
    }

    @Override
    public List<Empleado> listaEmpleados() {

        Session session = sessionFactory.getCurrentSession();

        Query<Empleado> query = session.createQuery("from Empleado", Empleado.class);

        return query.getResultList();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(empleado);

    }

    @Override
    public void eliminarEmpleado(int id) {

        Session session = sessionFactory.getCurrentSession();

        Empleado empleado = session.get(Empleado.class, id);

        session.delete(empleado);
    }
}
