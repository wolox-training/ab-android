package ar.com.wolox.android.example.model

class News(cTitle: String, cText: String, cPicture: String) {

    private var title: String = cTitle
    private var picture: String = cPicture
    private var text: String = cText
    private var like: Boolean = false

    fun isLike(): Boolean {
        return like
    }

    fun getTitle(): String {
        return title
    }

    fun getPicture(): String {
        return picture
    }

    fun getText(): String {
        return text
    }

    fun setLike(like: Boolean) {
        this.like = like
    }
}
