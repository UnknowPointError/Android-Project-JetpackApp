package cn.barry.jetpackapp.pixabay.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

object ModelEntity {

    object GET {

        data class PixabayEntity(

            @SerializedName("total")
            val total: Int,

            @SerializedName("totalHits")
            val totalHints: Int,

            @SerializedName("hits")
            val dataArray: List<PixabayImageEntity>
        ) {

            @Parcelize
            data class PixabayImageEntity(

                @SerializedName("id")
                val id: Int,

                @SerializedName("webformatURL")
                val webImageUrl: String,

                @SerializedName("largeImageURL")
                val largeImageUrl: String,

                @SerializedName("previewURL")
                val preUrl: String
            ) : Parcelable
        }

    }

    object POST {

    }
}