package es.crisvega.teclado

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun MiTeclado2() {

    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(Modifier
            .fillMaxWidth()
            .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

            ) {
            Image(
                painter = painterResource(id = R.drawable.pianista),
                contentDescription = "Descripción de la imagen"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            MusicBox(
                color = Color.Black,
                text = "DO",
                soundResId = R.raw.doo,
                context = context,
                modifier = Modifier.weight(1f)
            )
            MusicBox(
                color = Color.Cyan,
                text = "RE",
                soundResId = R.raw.re,
                context = context,
                modifier = Modifier.weight(1f)
            )
            MusicBox(
                color = Color.Black,
                text = "MI",
                soundResId = R.raw.mi,
                context = context,
                modifier = Modifier.weight(1f)
            )
            MusicBox(
                color = Color.Cyan,
                text = "FA",
                soundResId = R.raw.fa,
                context = context,
                modifier = Modifier.weight(1f)
            )
            MusicBox(
                color = Color.Black,
                text = "SOL",
                soundResId = R.raw.sol,
                context = context,
                modifier = Modifier.weight(1f)
            )
            MusicBox(
                color = Color.Cyan,
                text = "LA",
                soundResId = R.raw.la,
                context = context,
                modifier = Modifier.weight(1f)
            )
            MusicBox(
                color = Color.Black,
                text = "SI",
                soundResId = R.raw.si,
                context = context,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun MusicBox(
    color: Color,
    text: String,
    soundResId: Int,
    modifier: Modifier,
    context: Context,
    textColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .background(color)
            .fillMaxHeight()
            .clickable {
                val mediaPlayer = MediaPlayer.create(context, soundResId)
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener { mp ->
                    mp.release()
                }
            }
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                color = textColor,
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
    }
}
