package cn.barry.jetpackapp.pixabay.model

import com.google.gson.annotations.SerializedName

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

            data class PixabayImageEntity(

                @SerializedName("id")
                val id: Int,

                @SerializedName("webformatURL")
                val webImageUrl: String,

                @SerializedName("largeImageURL")
                val largeImageUrl: String,

                @SerializedName("previewURL")
                val preUrl: String
            )
        }

    }

    object POST {

    }
}