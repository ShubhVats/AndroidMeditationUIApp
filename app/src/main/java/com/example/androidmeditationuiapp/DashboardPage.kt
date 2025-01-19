package com.example.androidmeditationuiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidmeditationuiapp.ui.theme.Background
import com.example.androidmeditationuiapp.ui.theme.BackgroundMusic
import com.example.androidmeditationuiapp.ui.theme.PlayBackground
import com.example.androidmeditationuiapp.ui.theme.TextColor
import com.example.androidmeditationuiapp.ui.theme.TimeBackground

@Composable
fun DashboardPage(innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .background(color = Background)
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        SearchBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MusicCard(Modifier.weight(0.5f), side = "right")
            MusicCard(Modifier.weight(0.5f), side = "left")
        }
        BottomMusicList(Modifier.weight(1f))
        Footer()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Hello, Paul", fontWeight = FontWeight.W700, fontSize = 32.sp)
            Image(
                modifier = Modifier.size(40.dp)
//                    .scale(scaleX = -1f, scaleY = 1f),
                , painter = painterResource(R.drawable.goodbye), contentDescription = "Wave"
            )
        }
        Box(
            modifier = Modifier
                .background(color = Color.LightGray, shape = CircleShape)
                .padding(10.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                modifier = Modifier.size(30.dp)
//                    .scale(scaleX = -1f, scaleY = 1f),
                , painter = painterResource(R.drawable.notification), contentDescription = "Bell"
            )
        }

    }
}

@Composable
fun SearchBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(50.dp),
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        TextField(modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = { Text("Search...") },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                errorContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(R.drawable.search),
                    contentDescription = "Search...",
                    tint = Color.Black
                )
            })
    }
}

@Composable
fun MusicCard(modifier: Modifier, side: String) {
    Card(
        modifier = modifier
            .padding(
                start = when (side) {
                    "right" -> 0.dp
                    else -> 7.dp
                },
                end = when (side) {
                    "right" -> 7.dp
                    else -> 0.dp
                },
            )
            .background(
                color = when (side) {
                    "right" -> BackgroundMusic
                    else -> Color.White
                }, shape = RoundedCornerShape(20.dp)
            ), shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = when (side) {
                        "right" -> BackgroundMusic
                        else -> Color.White
                    }, shape = RoundedCornerShape(20.dp)
                )
                .padding(25.dp)
        ) {

            Text(
                text = when (side) {
                    "right" -> "Emotional\nBalance"
                    else -> "Calm\nRelaxing"
                }, fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = when (side) {
                    "right" -> TextColor
                    else -> Color.Black
                }
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.DarkGray, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = when (side) {
                            "right" -> "15 min"
                            else -> "12 min"
                        }, color = Color.White
                    )
                }
                Box(
                    Modifier
                        .background(color = PlayBackground, shape = CircleShape)
                        .padding(6.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
                }
            }
        }
    }
}

@Composable
fun BottomMusicList(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(), colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.White
        ), elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ), shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                    .align(Alignment.CenterHorizontally)
                    .height(5.dp)
                    .width(36.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Special for you", fontWeight = FontWeight.W700, fontSize = 24.sp)
            }
            LazyColumn {
                items(count = 5) {
                    MusicCardGratitude(side = it.toString())
                }
            }
        }
    }
}

@Composable
fun MusicCardGratitude(modifier: Modifier = Modifier, side: String = "right") {
    Card(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            .background(
                color = when (side) {
                    "right" -> PlayBackground
                    else -> PlayBackground
                }, shape = RoundedCornerShape(20.dp)
            ), shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = when (side) {
                        "right" -> PlayBackground
                        else -> PlayBackground
                    }, shape = RoundedCornerShape(20.dp)
                )
                .padding(top = 20.dp, start = 25.dp, end = 25.dp, bottom = 10.dp)
        ) {

            Text(
                text = when (side) {
                    "right" -> "Emotional Balance"
                    else -> "Calm Relaxing"
                }, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = when (side) {
                    "right" -> TextColor
                    else -> Color.Black
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Text(
                        text = when (side) {
                            "right" -> "15 min"
                            else -> "12 min"
                        },
                        color = Color.Black,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                    )
                    Text(
                        text = when (side) {
                            "right" -> "5 min"
                            else -> "2 min"
                        }, color = Color.Black, modifier = Modifier
                            .padding(end = 10.dp)
                            .background(
                                color = TimeBackground,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                    )
                }
                Box(
                    Modifier
                        .background(
                            color = when (side) {
                                "right" -> Color.White
                                else -> Color.White
                            }, shape = CircleShape
                        )
                        .padding(11.dp)
                ) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
                }
            }
        }
    }
}


@Composable
fun Footer(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp, top = 0.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconWithText(
            icon = Icons.Filled.Home,
            modifier = Modifier.size(30.dp),
            text = "Home",
            check = false
        )
        IconWithText(
            icon = Icons.Outlined.Refresh,
            modifier = Modifier.size(30.dp),
            text = "Exchange",
            check = false
        )
        IconWithText(
            icon = Icons.Outlined.MailOutline,
            modifier = Modifier.size(30.dp),
            text = "Transfer",
            check = false
        )
        IconWithText(
            icon = Icons.Outlined.AccountCircle,
            modifier = Modifier.size(30.dp),
            text = "Details",
            check = false
        )
    }
}
@Composable
fun IconWithText(
    text: String = "Send",
    icon: ImageVector = Icons.Filled.Add,
    modifier: Modifier = Modifier,
    check: Boolean = true
) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

            IconComponent(icon = icon, modifier = modifier)
           if (text=="Home"){
               Text(
                   text = text,
                   fontSize = 12.sp,
                   fontWeight = FontWeight.W700
               )

           }
    }

}

@Composable
fun IconComponent(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Person,
    colorBg: Color = Color.White,
    tint: Color = Color.Black
) {
    Icon(
        imageVector = icon,
        contentDescription = "Icon Component",
        modifier = modifier
            .background(color = colorBg)
            .padding(top = 3.dp),
        tint = tint
    )
}