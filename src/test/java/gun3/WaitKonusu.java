package gun3;

public class WaitKonusu {
    public static void main(String[] args) {
        /**
         * 1. Implicit wait
         * Tüm driver a tanimlanir.
         * Belirtilen süre boyunca element bulunana kadar bekler.
         * Bir kez ayarladiktan sonra driver kapanana kadar calisir.
         * Dezavantaji -> Tüm elementler icin calisir, gereksiz yere testleri yavaslatabilir.
         *
         * 2. Explicit wait
         * Sadece belirli bir web element icin bekleme yapar.
         * WebDriverWait + ExpectedConditions birlikte kullanir.
         * Elemet bulunursa belirtilen süreyi beklemez.
         * */
    }
}
