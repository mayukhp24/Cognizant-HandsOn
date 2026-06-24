class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface CustomerRepository {
    Customer findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(int id) {
        if (id == 1) {
            return new Customer(1, "Mayukh");
        }
        return new Customer(id, "Unknown");
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void printCustomer(int id) {
        Customer c = repository.findCustomerById(id);
        System.out.println("Customer found -> ID: " + c.getId() + ", Name: " + c.getName());
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.printCustomer(1);
        service.printCustomer(5);
    }
}
