## 1. Requirements

### Functional
- Search movies, theaters, and shows.
- View and select seats.
- Lock seats and book tickets.
- Process payments and confirm bookings.
- Admin manages movies, theaters, screens, and shows.
- View and cancel bookings.

### Non-Functional
- **Concurrency:** Prevent double booking.
- **TTL:** Expire seat locks (e.g., 8 minutes).
- **Consistency:** Maintain correct seat and booking states.
- **Payment Reliability:** Handle failures and duplicate callbacks.
- **Availability:** Handle peak traffic.

## 2. Core Entities

### Domain Entities
- `User` — Customer.
- `Movie` — Movie details.
- `Theater` — Theater and location.
- `Screen` — Belongs to a theater.
- `Seat` — Physical seat; `SeatType` enum.
- `Show` — Movie + screen + timing + pricing.
- `ShowSeat` — Show-specific seat status.
- `Booking` — User, seats, amount, status.
- `Payment` — Transaction details and status.

### Services
- `BookingService` — Booking workflow.
- `LockProvider` — Atomic seat locking + TTL.
- `PaymentService` — Payment coordination.
- `PaymentMethod` — Interface (UPI, Card, Net Banking).
- `AdminService` — Catalog management.

### Enums
`SeatType`, `SeatStatus`, `BookingStatus`, `PaymentStatus`

### Key Rules
- Theater → Screens → Seats.
- Show → Movie + Screen.
- Seat availability is show-specific.
- Lock all selected seats or none.
- Confirm only after successful payment and valid reservation.

### UML

<img width="1127" height="739" alt="image" src="https://github.com/user-attachments/assets/a5d9034e-017f-478f-bfec-103714158845" />

