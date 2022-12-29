package com.benyaamin.bamachallenge.presentation.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.benyaamin.bamachallenge.data.remote.dto.Address
import com.benyaamin.bamachallenge.data.remote.dto.Company
import com.benyaamin.bamachallenge.data.remote.dto.Geo
import com.benyaamin.bamachallenge.data.remote.dto.User
import com.benyaamin.bamachallenge.ui.CircularLoading
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun UsersScreen(
    viewModel: UsersViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Box(modifier = Modifier.fillMaxSize()) {
        state.data?.let {items ->
            LazyColumn {
                items(items.size) { index ->
                    UserItem(user = items[index])
                }
            }
        }
        
        CircularLoading(state.isLoading)

    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(modifier = Modifier
                .height(20.dp)) {
                Text(
                    text = user.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "@${user.username}",
                    fontSize = 10.sp,
                )
            }

            Section(title = "Contact") {
                Text(text = "- Phone:          ${user.phone}")
                Text(text = "- Email:          ${user.email}")
                Text(text = "- Website:        ${user.website}")
            }

            Section(title = "Company") {
                Text(text = "- Name:           ${user.company.name}")
                Text(text = "- CatchPhrase:    ${user.company.catchPhrase}")
                Text(text = "- BS:             ${user.company.bs}")
            }

            Section(title = "Address") {
                Text(text = "- Name:           ${user.address.street}")
                Text(text = "- CatchPhrase:    ${user.address.suite}")
                Text(text = "- BS:             ${user.address.city}")
                Text(text = "- ZipCode:        ${user.address.zipCode}")
                Text(text = "- Lat:            ${user.address.geo.lat}")
                Text(text = "- Lng:            ${user.address.geo.lng}")
            }
        }
    }
}

@Composable
fun Section(
    title: String,
    content: @Composable ColumnScope. () -> Unit
) {
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    Divider()
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    Column(modifier = Modifier
        .padding(start = 16.dp)
    ) {
        content()
    }
}

@Preview
@Composable
fun PreviewUsersScreen() {
    UsersScreen()
}