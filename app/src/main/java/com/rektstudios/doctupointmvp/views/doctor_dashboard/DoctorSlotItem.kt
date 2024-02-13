package com.rektstudios.doctupointmvp.views.doctor_dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot

@Composable
fun DoctorSlotItem(
	doctorSlot: DoctorSlot,
	onTotalSlotsChange:(totalSlots: Int, doctorSlot: DoctorSlot) -> Unit,
	onSlotAvailabilityChange:(slotAvailability: Boolean, doctorSlot: DoctorSlot) -> Unit,
	onSlotDelete:(doctorSlot: DoctorSlot) -> Unit,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Column(
			modifier = Modifier.weight(1f).padding(start = 5.dp),
			horizontalAlignment = Alignment.Start
		) {
			Text(
					text = "Time",
					fontWeight = FontWeight.SemiBold,
					fontSize = 16.sp,
					color = MaterialTheme.colorScheme.onBackground,
					overflow = TextOverflow.Ellipsis,
					maxLines = 1,
				)
			Text(
				text = doctorSlot.timeSlot,
				fontWeight = FontWeight.Medium,
				fontSize = 16.sp,
				color = MaterialTheme.colorScheme.onBackground,
				overflow = TextOverflow.Ellipsis,
				maxLines = 1,
			)

		}
		Spacer(modifier = Modifier.width(4.dp))
		Column(
			modifier = Modifier.weight(1f),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = "Total Slots",
				fontWeight = FontWeight.SemiBold,
				fontSize = 16.sp,
				color = MaterialTheme.colorScheme.onBackground,
				overflow = TextOverflow.Ellipsis,
				maxLines = 1,
			)
			OutlinedTextField(
				value = doctorSlot.totalSlots.toString(),
				onValueChange = {onTotalSlotsChange(it.toInt(),doctorSlot)},
				maxLines = 1,
				singleLine = true,
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
			)

		}
		Spacer(modifier = Modifier.width(4.dp))
		Column(
			modifier = Modifier.weight(1f),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = "Slot Availability",
				fontWeight = FontWeight.SemiBold,
				fontSize = 16.sp,
				color = MaterialTheme.colorScheme.onBackground,
				overflow = TextOverflow.Ellipsis,
				maxLines = 1,
			)
			Checkbox(
				checked = doctorSlot.slotAvailability,
				onCheckedChange = {onSlotAvailabilityChange(!doctorSlot.slotAvailability, doctorSlot)}
			)
		}
		Spacer(modifier = Modifier.width(4.dp))
		IconButton(
			onClick = {onSlotDelete(doctorSlot)}
		) {
			Icon(Icons.Filled.Delete, contentDescription = "Delete")
		}
	}
}

