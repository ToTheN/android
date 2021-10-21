package com.example.webservices

import android.util.Log
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object ApiClient {
    private val myApplication = MyApplication


        private const val TAG = "APIClient"
        private const val BASE_URL2 = "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json"
        private const val HEADER_CACHE_CONTROL = "Cache-Control"
        private const val HEADER_PRAGMA = "Pragma"
        private const val cacheSize = (5 * 1024 * 1024).toLong()



        /**
         * prepare and return okHttpClient
         */
        private fun okHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .cache(cache())
                .addInterceptor(httpLoggingInterceptor())
                .addInterceptor(offlineInterceptor())
                .addNetworkInterceptor(networkInterceptor())
                .build()
        }

        /**
         * prepare and return cache
         */
        private fun cache(): Cache {
            return Cache(File(myApplication.getinstance()?.cacheDir, "someIdentifier"), cacheSize)
        }

        /**
         * This interceptor will be called both if the network is available and if the network is not available
         * @return offlineInterceptor
         */
        private fun offlineInterceptor(): Interceptor {
            return Interceptor { chain ->
                var request = chain.request()

                // prevent caching when network is on. For that we use the "networkInterceptor"
                if (!MyApplication.hasnetwork()) {
                    val cacheControl = CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build()

                    request = request.newBuilder()
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .removeHeader(HEADER_PRAGMA)
                        .cacheControl(cacheControl)
                        .build()
                }
                chain.proceed(request)
            }
        }

        /**
         * This interceptor will be called ONLY if the network is available
         * @return networkInterceptor
         */
        private fun networkInterceptor(): Interceptor {
            return Interceptor { chain ->
                val response = chain.proceed(chain.request())

                val cacheControl = CacheControl.Builder()
                    .maxAge(5, TimeUnit.SECONDS)
                    .build()

                response.newBuilder()
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                    .removeHeader(HEADER_PRAGMA)
                    .build()
            }
        }

        /**
         * httpLoggingInterceptor instance
         */
        private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.d(TAG, "log: http log: $message") }
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }
}

