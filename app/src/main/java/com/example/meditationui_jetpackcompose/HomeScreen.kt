package com.example.meditationui_jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationui_jetpackcompose.ui.theme.ButtonBlue
import com.example.meditationui_jetpackcompose.ui.theme.DarkerButtonBlue
import com.example.meditationui_jetpackcompose.ui.theme.DeepBlue
import com.example.meditationui_jetpackcompose.ui.theme.LightRed
import com.example.meditationui_jetpackcompose.ui.theme.TextWhite

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ){
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep","Insomnia","Depression"))
            CurrentMeditation()

        }
    }
}


@Composable
fun GreetingSection(
    name: String = "Vivek"
){
    Row(
       horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Good Morning $name",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
        Icon(
            painter = painterResource(R.drawable.search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips : List<String>
){
    var selectedChipIndex by remember{
        mutableStateOf(0)
    }

    LazyRow {

        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp,top=15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if(selectedChipIndex==it)
                        ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(
                    text=chips[it],
                    color = TextWhite
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Daily Thoughts",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
            Text(
                text = "Meditation 3-10 min",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.play),
                contentDescription = "Play Button",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun FeaturesSection(
    features: List<Feature>
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = "Features",
            style = MaterialTheme.typography.bodyMedium,
            color = TextWhite,
            modifier = Modifier.size(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp,end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size){

            }
        }
    }
}

@Composable
fun FeatureItem(
    feature : Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight


        val mediumColourPoint1 = Offset(0f,height*0.3f)
        val mediumColourPoint2 = Offset(width*0.1f,height*0.35f)
        val mediumColourPoint3 = Offset(width*0.4f,height*0.05f)
        val mediumColourPoint4 = Offset(width*0.75f,height*0.7f)
        val mediumColourPoint5 = Offset(width*1.4f,-height.toFloat())

        val mediumColouredPath = Path().apply {
            moveTo(mediumColourPoint1.x,mediumColourPoint1.y)
//            quadraticBezierTo(
//                mediumColourPoint2.x,
//                mediumColourPoint2.y,
//
//            )
        }
    }
}

