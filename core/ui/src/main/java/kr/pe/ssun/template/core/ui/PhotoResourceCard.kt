package kr.pe.ssun.template.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.pe.ssun.template.core.domain.model.DPhoto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoResourcedCard(
    mainResource: DPhoto,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(80.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)) {
            AsyncImage(
                modifier = Modifier.size(80.dp),
                model = mainResource.thumbnailUrl,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxSize(),
                text = mainResource.title
            )
        }
    }
}