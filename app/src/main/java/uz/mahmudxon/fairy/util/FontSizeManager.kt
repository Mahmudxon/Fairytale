package uz.mahmudxon.fairy.util

class FontSizeManager(private val prefs: Prefs) {
    private val key = "fontSize"
    val default = 16
    val minSize = 10
    val maxSize = 30

    var currentSize: Int
        get() {
            return prefs.get(key, default)
        }
        set(value) {
            prefs.save(key, value)
        }
    val largeTextSize: Int
        get() {
            return currentSize + 2
        }
}