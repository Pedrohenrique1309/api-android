package com.example.myapplication.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.evaluateCubic
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.Cliente
import com.example.myapplication.ui.theme.MyApplicationTheme
import okhttp3.internal.connection.RouteException
import kotlin.math.cos

@Composable
fun HomeScreen (modifier: Modifier = Modifier){

    Scaffold (
        topBar = {
            BarraDeTitulo()
        },
        bottomBar = {
            BarraDeNavegacao()
        },
        floatingActionButton = {
            BotaoFlutuante()
        }
    ) {
        paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.onBackground
                )
        ){
            Row {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = ""
                ) 
                Text(text = "Lista de Clientes",
                    color = MaterialTheme.colorScheme.onPrimary)
            }
            LazyColumn {
                items (10) {
                    ClienteCard()
                }
            }
        }
    }


}

@Composable
fun ClienteCard (modifier: Modifier = Modifier){

    Card (

        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(start = 8.dp,
                end = 8.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Nome do Cliente")
                Text(text = "E-mail do Cliente")
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Excluir"
            )
        }
    }

}

@Preview
@Composable
private fun ClienteCardPreview(){
    ClienteCard()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  BarraDeTitulo(modifier: Modifier = Modifier){

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        colors = TopAppBarDefaults
            .topAppBarColors(
                containerColor = MaterialTheme
                    .colorScheme.primary
            ),
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Maria da Silva",
                        fontSize = 18.sp,
                        color = MaterialTheme
                            .colorScheme.onPrimary
                    )
                    Text(
                        text = "maria@emai.com",
                        fontSize = 16.sp,
                        color = MaterialTheme
                            .colorScheme.onPrimary

                    )
                }
                Card (
                    modifier = Modifier
                        .size(60.dp),
                    shape = CircleShape
                ){
                    Image(
                        painter = painterResource(R.drawable.men),
                        contentDescription = "Foto de Perfil",
                        contentScale = ContentScale.Crop
                    )

                }
            }
        }
    )

}

@Composable
private fun BarraDeNavegacao (modifier: Modifier = Modifier){
    NavigationBar (
        containerColor = MaterialTheme
            .colorScheme.primary
    ){
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = MaterialTheme
                        .colorScheme.onPrimary
                )
            },
            label = {
                Text(text = "Home",
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = MaterialTheme
                        .colorScheme.onPrimary
                )
            },
            label = {
                Text(
                    text = "Favorite",
                    color = MaterialTheme.colorScheme.onPrimary

                )

            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme
                        .colorScheme.onPrimary
                )
            },
            label = {
                Text(text = "Menu",
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        )
    }
}

@Composable
fun BotaoFlutuante(modifier: Modifier = Modifier){

    FloatingActionButton(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "adicionar"
        )
    }

}

@Preview
@Composable
private fun BotaoFlutuantePreview(){
    MyApplicationTheme {
        BotaoFlutuante()
    }
}

@Preview
@Composable
private fun BarraDeNavegacaoPreview(){
    MyApplicationTheme {
        BarraDeNavegacao()
    }
}

@Preview
@Composable
private fun BarraDeTituloPreview(){

    MyApplicationTheme (){
        BarraDeTitulo()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreview(){

    MyApplicationTheme(){
        HomeScreen()
    }

}