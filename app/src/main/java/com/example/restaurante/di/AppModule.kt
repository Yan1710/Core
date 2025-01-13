package com.example.restaurante.di

import com.example.restaurante.data.LoginApi
import com.example.restaurante.data.PedidoApi
import com.example.restaurante.utils.Constans.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return try {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Error al inicializar Retrofit: ${e.message}")
        }
    }
    @Singleton
    @Provides
    fun providesMovieApi(retrofit: Retrofit): PedidoApi{
        return retrofit.create(PedidoApi::class.java)
    }
    @Singleton
    @Provides
    fun providesLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }
}