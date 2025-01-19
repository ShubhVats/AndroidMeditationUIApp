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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidmeditationuiapp.ui.theme.BorderPink
import com.example.androidmeditationuiapp.ui.theme.CustomGray
import com.example.androidmeditationuiapp.ui.theme.Pink
import com.example.androidmeditationuiapp.ui.theme.Pink2

@Composable
fun MoodPage(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FaceCard(Modifier.weight(0.55f))
        BottomArea(Modifier.weight(0.45f))
    }

}


@Composable
fun FaceCard(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        ElevatedCard(
            colors = CardColors(
                contentColor = Color.Magenta,
                containerColor = Pink,
                disabledContentColor = Color.Magenta,
                disabledContainerColor = Color.Black
            ),
            shape = RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            CarouselBorder(Modifier.weight(0.1f))
            EmotionFace(Modifier.weight(0.9f))
        }

    }
}

@Composable
fun CarouselBorder(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .height(5.dp)
                .background(color = Color.Black, shape = CircleShape)
                .width(115.dp)
        )
        Box(
            modifier = Modifier
                .height(5.dp)
                .background(color = BorderPink, shape = CircleShape)
                .width(115.dp)
        )
        Box(
            modifier = Modifier
                .height(5.dp)
                .background(color = BorderPink, shape = CircleShape)
                .width(115.dp)
        )
    }
}

@Composable
fun EmotionFace(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .size(270.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.calm),
            contentDescription = "Emotion"
        )
    }
}

@Composable
fun BottomArea(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MoodRow()
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp),
            text = "How do you\nfeel today?",
            fontSize = 32.sp,
            color = Color.White,
            lineHeight = 35.sp,
            fontWeight = FontWeight.SemiBold
        )
        EndButtons()
    }
}

@Composable
fun MoodRow(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        LazyRow() {
            item {
                ButtonMood(text = "Sad", isSelected = false)
                ButtonMood(text = "Happy", isSelected = true)
                ButtonMood(text = "Angry", isSelected = false)
                ButtonMood(text = "Angry", isSelected = false)
            }
        }

    }
}

@Composable
fun ButtonMood(modifier: Modifier = Modifier, text: String, isSelected: Boolean = false) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Pink2 else CustomGray,
            contentColor = if (isSelected) Color.Black else Color.White
        ),
        onClick = {},
        elevation = ButtonDefaults.elevatedButtonElevation(),
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .width(155.dp)
            .height(48.dp)
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun EndButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
    ) {
        Button(
            modifier = Modifier
                .weight(0.3f)
                .height(50.dp), onClick = {}, colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Black
            )
        ) { Text(text = "Skip", fontSize = 15.sp) }
        Button(modifier = Modifier
            .weight(0.7f)
            .height(50.dp), onClick = {}, colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.White
        ), content = {
            Text(text = "Next", fontSize = 15.sp)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "next",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        })
    }
}