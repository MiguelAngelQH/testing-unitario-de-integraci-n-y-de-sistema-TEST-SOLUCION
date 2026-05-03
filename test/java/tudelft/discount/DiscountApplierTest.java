package tudelft.discount;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class DiscountApplierTest {
    @Test
    void applyDiscountToHomeProduct() {
        Product home = new Product("Sofá", 100.0, "HOME");
        ProductDao dao = Mockito.mock(ProductDao.class);
        Mockito.when(dao.all()).thenReturn(Arrays.asList(home));
        new DiscountApplier(dao).setNewPrices();
        Assertions.assertEquals(90.0, home.getPrice(), 0.001); // 90% del precio
    }

    @Test
    void applyDiscountToBusinessProduct() {
        Product business = new Product("PC", 100.0, "BUSINESS");
        ProductDao dao = Mockito.mock(ProductDao.class);
        Mockito.when(dao.all()).thenReturn(Arrays.asList(business));
        new DiscountApplier(dao).setNewPrices();
        Assertions.assertEquals(110.0, business.getPrice(), 0.001); // 110% del precio
    }

}
