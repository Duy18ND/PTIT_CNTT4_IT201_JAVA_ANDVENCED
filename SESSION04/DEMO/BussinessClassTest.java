//package SESSION04.DEMO;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class BussinessClassTest {
//
//    BussinessClass math = new BussinessClass();
//
//    @Test
//    void sum() {
//        // CỐ TÌNH TẠO LỖI Ở ĐÂY:
//        // Ai cũng biết 5 + 7 = 12, nhưng mình cố tình bắt nó phải bằng 99
//        int expected = 99;
//        int actual = math.sum(5, 7);
//
//        assertEquals(expected, actual, "Lỗi: Hàm cộng tính sai rồi!");
//    }
//
//    @Test
//    void substract() {
//        assertEquals(6, math.substract(10, 4), "Lỗi: Hàm trừ tính sai!");
//        assertEquals(-5, math.substract(5, 10), "Lỗi: Xử lý số âm sai!");
//    }
//
//    @Test
//    void multyply() {
//        assertEquals(12, math.multyply(3, 4));
//        assertEquals(0, math.multyply(999, 0));
//    }
//
//    @Test
//    void devide() {
//        assertEquals(5, math.devide(10, 2));
//        assertThrows(ArithmeticException.class, () -> {
//            math.devide(10, 0);
//        }, "Lỗi: Hàm chia không bắt được ngoại lệ chia cho 0!");
//    }
//}