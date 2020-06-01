package com.example.pruebastp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.pruebastp.data.Api
import com.example.pruebastp.data.Article
import com.example.pruebastp.data.ArticuloDetalleRecyclerAdapter
import com.example.pruebastp.data.Pictures
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var Imagenes = arrayOf(
        "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_1.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg"
    )
    var current : Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBuscar.setOnClickListener {
            buscarConCarrusel()
        }
        Picasso.get()
            .load("https://http2.mlstatic.com/frontend-assets/ui-navigation/5.6.0/mercadolibre/logo__large_plus.png")
            .into(imageViewML)
        btnIrABuscarArticulos.setOnClickListener {
            val intent = Intent(this, BusquedaArticulosActivity::class.java)
            startActivity(intent)

        }
       val carouselView = findViewById(R.id.carouselViewImgProduct) as CarouselView;
        carouselView.setPageCount(Imagenes.size); // Esto tiene que venir si o si con algo sino no me carga el carrousel. (Por ahora lo dejo asi porque esto seguramente lo llamare de
        // e la vista que me trae La busqueda de articulos. Por ende no deberia venir Null nunca. Lo dejo asi a fines de poder usarlo ahora.
        carouselView.setImageListener(imageListener);

/* NO prestar atencion. Fue un intento fallido por ahora
        val viewPager = viewPagerImgProduct as ViewPager
        val viewPagerAdapter = AdaptadorViewPager(Imagenes, this)
        viewPager.adapter(viewPagerAdapter)  No pude usar el viewPager porque tenia un error al querer setiar el adaptador */
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
            btnBuscar.setOnClickListener {
                buscarConCarrusel()
               //var verImagen = arrayOf(current?.pictures?.get(position)?.secure_url)
                Picasso.get().load(current?.pictures?.get(position)?.secure_url) // solo me muestra la ultima, nose si las demas no cargan porq. Me trae al buscar por segunda vez.
                    .into(imageView)
            }
        }
    }
    private fun buscarConCarrusel() {
        Api().getArticle(editTextProductoBuscar?.text.toString(), object : Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ocurriò un error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                if (response.isSuccessful) {
                    var article = response.body()
                    textViewArticle.text = "Titulo: ${article?.title}"
                    textViewArticlePrice.text = "$ ${article?.price}"

                    current = response.body()
                    lateinit var imagesArray: Array<String>
                    var adapatador: AdaptadorViewPager

                } else {
                    Toast.makeText(this@MainActivity, "Item no encontrado", Toast.LENGTH_LONG)
                        .show()
                }


            }
        })
    }

    }




/*
     private fun buscarConViewPager() {
        Api().getArticle(editTextProductoBuscar?.text.toString(), object : Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ocurriò un error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                if (response.isSuccessful) {
                    var article = response.body()
                    textViewArticle.text = "Titulo: ${article?.title}"
                    textViewArticlePrice.text = "$ ${article?.price}"

                   // Imagenes = article!!.pictures
                    lateinit var imagesArray: Array<String>
                    var adapatador: AdaptadorViewPager
                   // adapatador(article.pictures,)

                } else {
                    Toast.makeText(this@MainActivity, "Item no encontrado", Toast.LENGTH_LONG)
                        .show()
                }


            }
        })
    }*/



/*   private fun buscar() {
        Api().getArticle(editTextProductoBuscar?.text.toString(), object : Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ocurriò un error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                if (response.isSuccessful) {
                    var article = response.body()
                    textViewArticle.text = "Titulo: ${article?.title}"
                    textViewArticlePrice.text = "$ ${article?.price}"
                  //  article!!.pictures.forEach { pictures: Pictures ->Imagenes.fill() = pictures.secure_url   }

                        Imagenes = article!!.pictures
                        Picasso.get()
                            .load(article!!.pictures[0].secure_url.toString())
                            //.load("https://mla-s1-p.mlstatic.com/852497-MLA32566609369_102019-I.jpg")
                            .into(imageViewProducto)

                } else {
                    Toast.makeText(this@MainActivity, "Item no encontrado", Toast.LENGTH_LONG)
                        .show()
                }
            }


        })
    }*/