package uz.mahmudxon.fairy.util

class FontSizeManager(private val prefs: Prefs) {
    private val key = "fontSize"
    val default = 16
    var currentSize: Int
        get() {
            return prefs.get(key, default)
        }
        set(value) {
            prefs.save(key, default)
        }
    val largeTextSize: Int
        get() {
            return currentSize + 2
        }
}