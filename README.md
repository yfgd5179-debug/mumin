# AA Fix – Xiaomi Android Auto Sorun Giderici

Xiaomi (MIUI/HyperOS) telefonlarda Android Auto'nun **çökmesi, kopması ve
bağlanamaması** sorunları için hazırlanmış teşhis ve çözüm uygulaması.

> **Not:** Rootsuz bir uygulama telefon ayarlarını doğrudan değiştiremez.
> Bu uygulama sorunları **tespit eder** ve sizi doğru ayara **yönlendirir**.

## Özellikler

- **Teşhis Sihirbazı:** Cihaz markası, Android Auto kurulumu, Play Hizmetleri
  sürümü, pil optimizasyonu, geliştirici seçenekleri, USB yapılandırması,
  MIUI optimizasyonu ve Wi-Fi durumunu kontrol eder. Bulduğu her sorun için
  tek dokunuşla ilgili ayar ekranını açar.
- **Adım Adım Rehber:** MIUI arka plan kısıtlamaları, USB kablosu testi,
  kablosuz Android Auto ayarları dahil kapsamlı çözüm adımları.
- **ADB Komutları:** Bilgisayar üzerinden yapılabilecek ileri düzey
  düzeltmelerin komut listesi (kopyala düğmesiyle).

## Projeyi açma (Android Studio)

1. [Android Studio](https://developer.android.com/studio) kurun (Ladybug veya üzeri).
2. Android Studio'yu açın → **Open** → bu klasörü seçin.
3. Gradle senkronizasyonunu bekleyin (ilk seferde bağımlılıklar indirilir).
4. Bir telefon bağlayın (USB hata ayıklama açık) veya emülatör oluşturun.
5. **Run ▶** düğmesine basın.

> JDK 17, Android Studio ile birlikte gelir; ayrı kurmanız gerekmez.

## Telefone kurma (APK üretimi)

1. Android Studio'da **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
2. Oluşan APK: `app/build/outputs/apk/debug/app-debug.apk`
3. Telefonda bilinmeyen kaynaklardan kurma iznini verip APK'yı açın.

## Yayın öncesi yapılacaklar

- `app/build.gradle.kts` içindeki `applicationId = "com.example.aafix"` değerini
  kendi alan adınızla değiştirin (örn. `com.adiadiniz.aafix`).
- `app/src/main/res/` klasörüne kendi uygulama simgenizi ekleyin ve
  `AndroidManifest.xml` içindeki `android:icon` değerini güncelleyin.
- Play Store için **Build → Generate Signed App Bundle** seçeneğini kullanın.

## Proje yapısı

```
app/src/main/java/com/example/aafix/
├── MainActivity.kt            # Ekran geçişleri ve ayar niyetleri (intent)
├── DiagnosticEngine.kt        # Teşhis kontrolleri (ayar okuma)
└── ui/
    ├── Theme.kt               # Renk teması
    └── screens/
        ├── HomeScreen.kt      # Ana ekran
        ├── WizardScreen.kt    # Teşhis sonuçları + "Düzelt" düğmeleri
        ├── GuideScreen.kt     # Adım adım rehber
        └── AdbScreen.kt       # ADB komut listesi
```

## Sık karşılaşılan Xiaomi Android Auto sorunları ve bu uygulamanın yaklaşımı

| Sorun | Teşhis | Çözüm yönlendirmesi |
|---|---|---|
| Bağlansa da arka planda kopuyor | Pil optimizasyonu kontrolü | Android Auto'ya 'Sınırsız' pil izni |
| USB takınca hiç görmüyor | Varsayılan USB yapılandırması | MTP olarak ayarla |
| Bağlantı kararsız | MIUI optimizasyonu durumu | Geliştirici seçenekleri / ADB |
| Oyun modu-arama sırasında kopma | Arka plan kısıtlaması rehberi | Uygulama izinleri adımları |
| Kablosuz bağlantı kurulamıyor | Wi-Fi durumu + rehber | 5 GHz, eşleşme, güç modu adımları |
